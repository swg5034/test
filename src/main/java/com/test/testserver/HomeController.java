package com.test.testserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.test.dto.MemberDto;
import com.test.service.MemberServiceImpl;

@SessionAttributes("member")
@Controller
public class HomeController {
	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/loginPage")
	public String login() {
		return "loginPage";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        System.out.println("controller id = " + id);
        System.out.println("controller pw = " + pw);
        MemberDto m = new MemberDto(id, pw);
        service.login(m);
        if(m!=null) {
        	if(m.getPw().equals(pw)) {
        		model.addAttribute("dto", m);
        		HttpSession session = request.getSession();
        		session.setAttribute("loginId", m.getId());
        		return "main";
        	}
        }else {
        	System.out.println("로그인 정보가 없습니다c");
        	return "loginpage";
        }
        return "home";
    }
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		if(!status.isComplete()) {
			status.setComplete();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/joinPage")
	public String joinPage() {
		return "joinPage";
	}
	
	@RequestMapping(value = "/join")
	public String join(HttpSession session, SessionStatus status) {
		if(!status.isComplete()) {
			status.setComplete();
		}
		return "loginpage";
	}
	
	@RequestMapping(value = "/start")
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("스케줄러가 시작됨.");
		return "home";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("스케줄러가 종료됨.");
		return "home";
	}
}
