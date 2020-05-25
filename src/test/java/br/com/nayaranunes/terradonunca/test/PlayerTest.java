package br.com.nayaranunes.terradonunca.test;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import br.com.nayaranunes.terradonunca.model.PlayerResponse;
import br.com.nayaranunes.terradonunca.repository.PlayerRepository;
import br.com.nayaranunes.terradonunca.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class PlayerTest {

    @MockBean
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player player;
    private PlayerRequest request;
    private PlayerResponse response;

    @Before
    public void setup() {
        playerService = new PlayerService(playerRepository);
        request = new PlayerRequest("Cassio", "54545",1);
        response = new PlayerResponse("Fabio", "54321",1);
        player = new Player("Rogerio", "12345",1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addPlayerOK() {
        Assertions.assertThat(this.playerService.addPlayer(request) == 1);
        Assertions.assertThat(request.getName()).isEqualTo("Cassio");
        Assertions.assertThat(request.getCpf()).isEqualTo("54545");
    }


}
