package br.com.nayaranunes.terradonunca.test;

import br.com.nayaranunes.terradonunca.domain.Championship;
import br.com.nayaranunes.terradonunca.repository.ChampionshipRepository;
import br.com.nayaranunes.terradonunca.service.ChampionshipService;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ChampionshipTest {

    @MockBean
    private ChampionshipRepository championshipRepository;

    @InjectMocks
    private ChampionshipService championshipService;

    private static Championship championship;

    @BeforeClass
    public static void beforeClass() {
        championship = new Championship(1,2020,"Copa",1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addChampionshipOK() {
        championship = new Championship(1,2020,"Copa",1);
        Assertions.assertThat(this.championshipService.addChampionship(championship) == championship.getId());
        Assertions.assertThat(championship.getId() == 1);
        Assertions.assertThat(championship.getPhase() == 1);
        Assertions.assertThat(championship.getName()).isEqualTo("Copa");
        Assertions.assertThat(championship.getYear() == 2020);

    }
}
