package ch.efg.sample.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IUser {

    private String id;

    private String name;

    private String groupId;
}
