package miu.edu.aop.service;

import lombok.RequiredArgsConstructor;
import miu.edu.aop.dto.ActivityLogDTO;
import miu.edu.aop.model.ActivityLog;
import miu.edu.aop.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository repository;
    static ModelMapper mapper = new ModelMapper();
    private static final Function<ActivityLog, ActivityLogDTO> toDTO = item -> mapper.map(item, ActivityLogDTO.class);
    private static final Function<ActivityLogDTO, ActivityLog> toEntity = item -> mapper.map(item, ActivityLog.class);

    public List<ActivityLogDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ActivityLogDTO> findOne(Long id) {
        return repository.findById(id)
                .map(toDTO);
    }

    public ActivityLogDTO save(ActivityLogDTO activity) {
        return toDTO.apply(repository.save(toEntity.apply(activity)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
