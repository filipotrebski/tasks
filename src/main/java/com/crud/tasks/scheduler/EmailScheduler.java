package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks; Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildInformationEmail() {
        long size = taskRepository.count();

        String message = "Currently in database you got: " + size + (size == 1 ? " task" : " tasks");

        Context context = new Context();
        context.setVariable("preview_message", SUBJECT);
        context.setVariable("message", message);
        context.setVariable("task_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("goodbye_message", "Have a nice day");
        context.setVariable("button","Task List");
        context.setVariable("show_button", true);
        context.setVariable("admin_config", adminConfig);
        return templateEngine.process("mail/information-mail",context);
    }


    @Scheduled(cron = "* * 7 * * *")
    public void sendInformationEmail() {
        simpleEmailService.sendInformationEmail(new Mail(adminConfig.getAdminMail(),SUBJECT,""));
//        long size = taskRepository.count();
//
//        simpleEmailService.send(new Mail(
//                adminConfig.getAdminMail(),
//                SUBJECT,
//                "Currently in database you got: " + size +
//                        (size == 1 ? " task" : " tasks")
//        ));
    }
}
