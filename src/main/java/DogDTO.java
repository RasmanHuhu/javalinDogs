import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

    @Getter
    @NoArgsConstructor
    @ToString
    public class DogDTO {

        int id;
        String name;
        String breed;
        String gender;
        int age;

        public DogDTO(String name, String breed, String gender, int age) {
            this.name = name;
            this.breed = breed;
            this.gender = gender;
            this.age = age;
        }
    }
