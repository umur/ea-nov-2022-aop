package miu.edu.aop.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ActivityLogDTO {
    private Long id;
    private LocalDateTime date;
    private String operation;
    private Long duration;
}