package org.spring.springboot.service;

import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogService extends Service{
    List<Log> findAllLogs();
<<<<<<< HEAD
    List<Log> findLogsByUserId(int UserId);
=======
    List<Log> findLogsByUserId(Integer UserId);
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
}
