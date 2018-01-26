public interface EmailService{
    @Autowired
    Mail mail;

    void sendSimpleMessage(mail);


}
