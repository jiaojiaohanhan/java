package com.timer;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.entity.Exam;
import com.service.ExamService;

@Component
public class RemindTimer {
	private Logger logger = LogManager.getLogger(RemindTimer.class);
	@Autowired
	private ExamService examService;
	@Scheduled(cron = "0 0 6 * * *")
	public void sendMessage() {
		Date date = new Date();
		List<Exam> exams = examService.list();
		for(int i=0; i<exams.size();i++) {
			if(exams.get(i).getStartTime().before(date)) {
				logger.debug("监考提醒：");
				logger.debug("考试名称："+ exams.get(i).getExamName());
				logger.debug("考试地点："+ exams.get(i).getAddress());
				logger.debug("监考老师："+ exams.get(i).getUsers());
				logger.debug("开始时间："+ exams.get(i).getStartTime());
				logger.debug("结束时间："+ exams.get(i).getEndTime());
				logger.debug("不要忘记去监考哟(＾Ｕ＾)ノ~Orz");
			}
		}
		
	}
}