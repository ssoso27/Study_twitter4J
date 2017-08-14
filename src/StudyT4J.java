import java.util.List;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class StudyT4J {
	private final int dmCount = 20;
	TwitterFactory tf;
	twitter4j.Twitter twitter;
	ConfigurationBuilder cf; 
	
	public StudyT4J()
	{
		cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("o2vVCGim4XNpVCOg6KH1N7E93")
		.setOAuthConsumerSecret("D1UN8ayU0VhOw4QDyP3FCDFehNdjbPzhS0KZ5QQAM0WPpJ34Ac")
		.setOAuthAccessToken("269166725-yG8lfZbqJKz3puBOHOAm8ggHvS7qERVlr1eXL80Z")
		.setOAuthAccessTokenSecret("XANl5nJ5jF2UBOZWrnM7Ee3aMAW127MCm154qmy4qXGZf");
		
		tf = new TwitterFactory(cf.build());
		twitter = tf.getInstance();
	}
	
	public void showMyDM() throws TwitterException
	{
		List<DirectMessage> receiveDM = twitter.getDirectMessages();
		List<DirectMessage> sentDM = twitter.getSentDirectMessages();
		
		int r_index = 0, s_index = 0; 
		long r_id, s_id;
		DirectMessage dm;
		
		for (int i = dmCount - 1; i >= 0; i--)
		{
			r_id = receiveDM.get(r_index).getId();
			s_id = sentDM.get(s_index).getId();
			
			if (r_id > s_id)
			{
				dm = receiveDM.get(r_index);
				System.out.println("[수신] " + dm.getSender().getName() + " ( @" + dm.getSenderScreenName() + " )");
				System.out.println(dm.getText());
				
				r_index++;
			}
			else if (r_id < s_id)
			{
				dm = sentDM.get(s_index);
				System.out.println("[송신] " + dm.getSender().getName() + " ( @" + dm.getSenderScreenName() + " )");
				System.out.println(dm.getText());
				
				s_index++;
			}
			else
			{
				System.out.println("에러발생 : r_index : " + r_index + " s_index : " + s_index + " i : " + i);
			}
		}
	}
	
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		StudyT4J study = new StudyT4J();
		
		study.showMyDM();
		
//		ConfigurationBuilder cf = new ConfigurationBuilder();
		
//		cf.setDebugEnabled(true)
//			.setOAuthConsumerKey("o2vVCGim4XNpVCOg6KH1N7E93")
//			.setOAuthConsumerSecret("D1UN8ayU0VhOw4QDyP3FCDFehNdjbPzhS0KZ5QQAM0WPpJ34Ac")
//			.setOAuthAccessToken("269166725-yG8lfZbqJKz3puBOHOAm8ggHvS7qERVlr1eXL80Z")
//			.setOAuthAccessTokenSecret("XANl5nJ5jF2UBOZWrnM7Ee3aMAW127MCm154qmy4qXGZf");
		
//		TwitterFactory tf = new TwitterFactory(cf.build());
//		twitter4j.Twitter twitter = tf.getInstance();
		
//		// get timeline 		
//		List<Status> status = twitter.getHomeTimeline();
//		for (Status st : status)
//		{
//			System.out.println(st.getUser().getName() + "\n" + st.getText() + "\n ---------------------");
//		}
		
//		// get 받은 dm
//		List<DirectMessage> receiveDM = twitter.getDirectMessages();
//		for (DirectMessage dm : receiveDM)
//		{
//			System.out.println(dm.getSender().getName() + " ( id :: " + dm.getId() + " ) ");
//			System.out.println(dm.getText());
//		}
//		
//		System.out.println("=======================================");
//		
//		// get 보낸 dm
//		List<DirectMessage> sentDM = twitter.getSentDirectMessages();
//		for (DirectMessage dm : sentDM)
//		{
//			System.out.println(dm.getSender().getName() + " ( id :: " + dm.getId() + " ) ");
//			System.out.println(dm.getText());
//		}
		
		// sent dm
	//		DirectMessage testDM = twitter.sendDirectMessage("@sae_ssak_da, "텥스트 디엠");
	}
}
