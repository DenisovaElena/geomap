package ru.gbuac.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gbuac.HasId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTo implements HasId {

    protected Integer id;
}
