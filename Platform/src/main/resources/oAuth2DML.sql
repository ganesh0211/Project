INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	("client1", "secret1", "foo,read,write", "password,authorization_code,refresh_token",
	 "http://client1/", null, 36000, 36000, null, true);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	("client2", "secret2", "read,write,foo,bar","implicit",
	 "http://client2/", null, 36000, 36000, null, false);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	("client3", "secret3", "bar,read,write","password,authorization_code,refresh_token",
	 "http://client3/", null, 36000, 36000, null, true);

commit;