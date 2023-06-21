
execute docker-compose to start keycloak auth server
admin credentials can found compose file


create playground realm in keycloak
create client credentials in keycloak


http://localhost:8090/realms/playground/.well-known/openid-configuration

to get token use the following URL
"token_endpoint": "http://localhost:8090/realms/playground/protocol/openid-connect/token",