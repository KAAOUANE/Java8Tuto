import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by admin on 11/03/2018.
 */
public class OptionalTest {

    @Test
    public void testOptionalEmpty(){
        Optional<String> empty = Optional.empty();
        Assertions.assertThat(empty.isPresent()).isFalse();
    }
    @Test
    public void testOptionalNull(){
        Optional<String> nullable = Optional.ofNullable(null);
        Assertions.assertThat(nullable.isPresent()).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptionalException(){
        Optional<Integer> empty = Optional.empty();
        Assertions.assertThat(empty.orElseThrow(() -> new IllegalArgumentException()));
        Assertions.assertThat(empty.orElseThrow(IllegalArgumentException::new));
    }
    @Test
    public void testOptionalOrElse(){
        Optional<Integer> empty = Optional.empty();
        Assertions.assertThat(empty.orElse(2)).isEqualTo(2);
        Assertions.assertThat(empty.orElseGet(() -> 2)).isEqualTo(2);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "textParDefaut";

        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        Assertions.assertThat(defaultText).isEqualTo("textParDefaut");

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        Assertions.assertThat(defaultText).isEqualTo("textParDefaut");
    }

    public String getMyDefault() {
        return "Default Value";
    }

    @Test
    public void testOptionalPresent(){
        Optional<Integer> one = Optional.of(1);
        Assertions.assertThat(one.isPresent()).isTrue();
        Assertions.assertThat(one.get()).isEqualTo(1);
    }
}
