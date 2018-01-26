
public class EmailServiceImpl implements EmailService{
    public static Logger logger = Logger.getLogger(EmailService.class)

    @Autowired
    public JavaMailSender emailSender;


    public void sendSimpleMessage(Email email){
        try{

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getFrom());
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getContent());
        } catch(MailException exception){
            logger.warn(exception.printStackTrace());
        }

    }
}
