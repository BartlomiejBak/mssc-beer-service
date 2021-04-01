package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository repository;

    public BeerLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {
        if (repository.count() == 0) {
            repository.save(Beer.builder()
                    .beerName("one")
                    .beerStyle("IPA")
                    .quantityToBrew(300)
                    .minOnHand(55)
                    .price(new BigDecimal("10.00"))
                    .upc(123456L)
                    .build());
            repository.save(Beer.builder()
                    .beerName("two")
                    .beerStyle("STOUT")
                    .quantityToBrew(301)
                    .minOnHand(56)
                    .price(new BigDecimal("11.00"))
                    .upc(123457L)
                    .build());
            repository.save(Beer.builder()
                    .beerName("three")
                    .beerStyle("PORTER")
                    .quantityToBrew(302)
                    .minOnHand(57)
                    .price(new BigDecimal("12.00"))
                    .upc(123458L)
                    .build());
            repository.save(Beer.builder()
                    .beerName("four")
                    .beerStyle("LAGER")
                    .quantityToBrew(303)
                    .minOnHand(58)
                    .price(new BigDecimal("13.00"))
                    .upc(123459L)
                    .build());
            System.out.println("loaded beers: " + repository.count());
        }
    }

}
