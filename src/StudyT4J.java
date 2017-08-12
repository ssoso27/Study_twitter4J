import java.util.List;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class StudyT4J {
	
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		ConfigurationBuilder cf = new ConfigurationBuilder();
		
		cf.setDebugEnabled(true)
			.setOAuthConsumerKey("o2vVCGim4XNpVCOg6KH1N7E93")
			.setOAuthConsumerSecret("D1UN8ayU0VhOw4QDyP3FCDFehNdjbPzhS0KZ5QQAM0WPpJ34Ac")
			.setOAuthAccessToken("269166725-yG8lfZbqJKz3puBOHOAm8ggHvS7qERVlr1eXL80Z")
			.setOAuthAccessTokenSecret("XANl5nJ5jF2UBOZWrnM7Ee3aMAW127MCm154qmy4qXGZf");
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter = tf.getInstance();
		
//		// get username, status 		
//		List<Status> status = twitter.getHomeTimeline();
//		for (Status st : status)
//		{
//			System.out.println(st.getUser().getName() + "\n" + st.getText() + "\n ---------------------");
//		}
		
		// get dm
		List<DirectMessage> directMessage = twitter.getDirectMessages();
		for (DirectMessage dm : directMessage)
		{
			System.out.println(dm.getSender().getName() + " ( @" + dm.getSenderScreenName() + " ) ");
			System.out.println(dm.getText());
		}
	}
}
