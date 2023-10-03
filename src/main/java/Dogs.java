import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

    @Getter
    @NoArgsConstructor
    @ToString
    public class Dogs {

        String name;
        int yearOfBirth;

        public Dogs(String name, int yearOfBirth) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }
