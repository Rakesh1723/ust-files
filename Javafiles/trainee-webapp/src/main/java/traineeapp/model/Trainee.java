package traineeapp.model;

import java.time.LocalDate;

public class Trainee {
        private int id;
        private String name;
        private String location;
        private LocalDate joinedDate;

        public Trainee(int id, String name, String location, LocalDate joinedDate) {
                this.id = id;
                this.name = name;
                this.location = location;
                this.joinedDate = joinedDate;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public void setJoinedDate(LocalDate joinedDate) {
                this.joinedDate = joinedDate;
        }

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getLocation() {
                return location;
        }

        public LocalDate getJoinedDate() {
                return joinedDate;
        }

        @Override
        public String toString() {
                return "Trainee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", location='" + location + '\'' +
                        ", joinedDate=" + joinedDate +
                        '}';
        }
}

