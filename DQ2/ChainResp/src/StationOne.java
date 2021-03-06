import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class StationOne implements Filter{

	public void init(FilterConfig arg0) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out=resp.getWriter();
		
		pushReceiveNotification(out);
		
		chain.doFilter(req, resp);//sends request to next resource
		
		pushReadNotification(out);
		
	}
	public void destroy() {}

	public void pushReceiveNotification(PrintWriter out) {
		out.print("StationOne recieved message!<br/>");
	}
	
	public void pushReadNotification(PrintWriter out) {
		out.print("StationOne has read the message!<br/>");
	}

}
