package com.quality.collab.poc.authorizations.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.quality.collab.poc.authorizations.dto.AuthorizationResponse;
import com.quality.collab.poc.authorizations.utils.HttpGetWithEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.apache.http.entity.StringEntity;

import org.springframework.http.HttpEntity;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
public class AuthorizationService {

    private static final String PERMISSIONS_REQUEST_OBJECT_ROOT = "permissions";
    private static final String FAILED_TO_RETRIEVE_USER_PERMISSIONS = "Failed to retrieve user permissions";
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public boolean isAuthorized(String name, String action) throws Exception {
        String token = getTokenFromSecurityContext();
        String issuer = getIssuerFromJwt();
        String permissionKey = name + "#" + action;

        StringEntity permissionsOfInterestStringEntity = new StringEntity(
                getCorePermissionNames(List.of(permissionKey)),
                ContentType.APPLICATION_JSON);

        try {

            HttpGetWithEntity httpGetWithEntity = new HttpGetWithEntity();
            httpGetWithEntity.setURI(new URI(String.format("%s/api/permissions", issuer)));
            httpGetWithEntity.setEntity(permissionsOfInterestStringEntity);
            httpGetWithEntity.setHeader("accept", "application/json");
            httpGetWithEntity.setHeader("Authorization", "Bearer " + token);

            // We can't use OpenAPI 3 to generate a client of Core's permissions API because the latter's requests use
            // the GET verb in conjunction with a body, something that is somewhat frowned upon and (therefore) unsupported by OpenAPI 3.
            CloseableHttpClient httpClient = getHttpClient();
            try (CloseableHttpResponse response = httpClient.execute(httpGetWithEntity)) {
                final int responseStatusCode = response.getStatusLine().getStatusCode();
                if (!HttpStatus.valueOf(responseStatusCode).is2xxSuccessful()) {
                    throw new Exception(FAILED_TO_RETRIEVE_USER_PERMISSIONS);

                }

                String responseBody = EntityUtils.toString(response.getEntity());
                AuthorizationResponse authResponse = objectMapper.readValue(responseBody, AuthorizationResponse.class);

                Map<String, Boolean> permissionMap = authResponse.getData();
                return Boolean.TRUE.equals(permissionMap.get(permissionKey));
            }

        }
        catch (Exception e) {
            throw new Exception(FAILED_TO_RETRIEVE_USER_PERMISSIONS);
        }

    }

    CloseableHttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }

    public String getTokenFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken) {
            return ((JwtAuthenticationToken) authentication).getToken().getTokenValue();
        }

        throw new IllegalStateException("Bearer token not found in security context");
    }

    public String getIssuerFromJwt() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtAuthToken) {
            Jwt jwt = jwtAuthToken.getToken();
            return jwt.getIssuer().toString(); // returns URI (e.g., "http://localhost:46880")
        }

        throw new IllegalStateException("JWT Authentication not found");
    }

    String getCorePermissionNames(List<String> permissionsOfInterestList) {

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayElement = new JsonArray();
        for (String permission : permissionsOfInterestList) {
            jsonArrayElement.add(permission);
        }
        jsonObject.add(PERMISSIONS_REQUEST_OBJECT_ROOT, jsonArrayElement);
        return new Gson().toJson(jsonObject);
    }
}
