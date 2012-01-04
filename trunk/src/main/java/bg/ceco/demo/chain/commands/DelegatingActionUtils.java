package bg.ceco.demo.chain.commands;

import java.text.MessageFormat;

import org.apache.struts.action.ActionServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

public abstract class DelegatingActionUtils extends
		org.springframework.web.struts.DelegatingActionUtils {
	/**
	 * Value of the autowire init-param that indicates autowiring by
	 * constructor: "constructor"
	 */
	public static final String AUTOWIRE_CONSTRUCTOR = "constructor";
	
	/**
	 * Determine the autowire mode from the "autowire" init-param of the Struts
	 * ActionServlet, falling back to "AUTOWIRE_CONSTRUCTOR" as default.
	 * 
	 * @param actionServlet
	 *            the Struts ActionServlet
	 * @return the autowire mode to use
	 * 
	 * @see org.springframework.web.struts.DelegatingActionUtils
	 */
	public static int getAutowireMode(ActionServlet actionServlet) {
		String autowire = actionServlet.getInitParameter(PARAM_AUTOWIRE);
		if (autowire != null) {
			if (AUTOWIRE_BY_NAME.equals(autowire)) {
				return AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;
			} else if (AUTOWIRE_BY_TYPE.equals(autowire)) {
				return AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR;
			} else if (!AUTOWIRE_CONSTRUCTOR.equals(autowire)) {
				String message = "ActionServlet '{0}' init parameter must be '{1}', '{2}' or '{3}'";
				throw new IllegalArgumentException(MessageFormat.format(
						message, PARAM_AUTOWIRE, AUTOWIRE_BY_NAME,
						AUTOWIRE_BY_TYPE, AUTOWIRE_CONSTRUCTOR));
			}
		}
		return AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR;
	}
}
