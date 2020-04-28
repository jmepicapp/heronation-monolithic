package com.hackathlon.heronation.jobs;

import com.hackathlon.heronation.repository.PeticionRepository;
import com.hackathlon.heronation.util.type.EstadoPeticion;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import static java.time.temporal.ChronoUnit.HOURS;


import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskSchedulers{
    Logger logger = LoggerFactory.getLogger(TaskSchedulers.class);
    @Autowired
    private final PeticionRepository peticionRepository;
    private  static Integer PARAMETRO_HORA_MAXIMA = 48;

    public TaskSchedulers(PeticionRepository peticionRepository) {
        this.peticionRepository = peticionRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(name = "ExecuteTask", lockAtLeastFor = "15S", lockAtMostFor = "20S")
    public void executeTask() throws InterruptedException {
      List<Long> idPeticiones  = getCancelarPeticiones();
            if(!idPeticiones.isEmpty()){
            logger.info("Id peticiones canceladas {}",idPeticiones);
            }
        Thread.sleep(1000L);
    }

    private List<Long> getCancelarPeticiones() {
        return peticionRepository.findAllByEstadoPendiente()
                  .stream()
                  .filter(pt ->  HOURS.between(pt.getFechaCreacion(), LocalDateTime.now()) > PARAMETRO_HORA_MAXIMA)
                  .map(peticion -> {
                      peticion.setEstado(EstadoPeticion.CANCELADO.name());
                      peticion.setDescripcionEmpresa(String.format("La peticion se ha cancelado, no fue aceptada en %s horas",PARAMETRO_HORA_MAXIMA));
                      return  peticion;
                  }).map(pt -> peticionRepository.save(pt))
                  .map(pt -> pt.getId())
                  .collect(Collectors.toList());
    }
}
