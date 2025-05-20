package edu.fbansept.estiam25cidc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthMetrics {

    protected boolean online = true;
    protected int cpu = 0;
    protected int memory = 0;

}
