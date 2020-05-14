/*
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
import org.springframework.test.context.junit4.SpringRunner;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@DataJpaTest

@RunWith(SpringRunner.class)
public class PlayerTest {
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player player;
    private PlayerRequest request;
    private PlayerResponse response;

    @Before
    public void setup() {
        playerService = new PlayerService(playerRepository);
        request = new PlayerRequest("Cassio", "54545");
        response = new PlayerResponse("Fabio", "54321");
        player = new Player("Rogerio", "12345");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addPlayerOK() {
        Assertions.assertThat(this.playerService.addPlayer(request) == 1);
        Assertions.assertThat(request.getName()).isEqualTo("Cassio");
        Assertions.assertThat(request.getCPF()).isEqualTo("54545");
    }

    @Test
    public void playerAlreadyExistsOK() {
        //Assertions.assertThat(playerService.playerAlreadyExists(player.getCPF())); //true
       // Player p = new Player(); //this player does'nt exists in repository
       // Assertions.assertThat(!(playerService.playerAlreadyExists(p.getCPF())));    //false
    }
    */
/*
    @Test
    public void deletePlayerByCPF() {
        this.playerService.addPlayer(request);
        Assertions.assertThat(playerService.deletePlayerByCPF(request.getCPF())).isEqualTo(1);
    }
     *//*

}
*/
