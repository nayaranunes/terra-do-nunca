/*
import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.TeamRequest;
import br.com.nayaranunes.terradonunca.TeamRepository;
import br.com.nayaranunes.terradonunca.TeamService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TeamTest {
    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Player player;
    private Team team;
    private TeamRequest request;

    @Before
    public void setup() {
        teamService = new TeamService(teamRepository);
        player = new Player("Ronaldo", "54545", 1);
        request = new TeamRequest("Mauro", "5454-5", "Para", 1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addTeamOK() {
        //Team team = new Team("")
        Assertions.assertThat(this.teamService.addTeam(request) == 1);
        Assertions.assertThat(request.getCoach()).isEqualTo("Mauro");
        Assertions.assertThat(request.getCnpj()).isEqualTo("5454-5");
        Assertions.assertThat(request.getName()).isEqualTo("Para");
    }
}
*/
