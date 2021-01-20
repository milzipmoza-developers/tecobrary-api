package dev.milzipmoza.tecobrary.core.client.github;

import dev.milzipmoza.tecobrary.core.client.ClientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GithubApiClientTest {

    @Autowired
    private GithubApiClient client;

    @Test
    void request() {
        assertThrows(ClientException.class, () -> client.getPrimaryEmail("aaa"));
    }
}