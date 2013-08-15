//package bg.ceco.demo.chain.commands;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionServlet;
//import org.apache.struts.chain.commands.servlet.CreateAction;
//import org.apache.struts.chain.commands.util.ClassUtils;
//import org.apache.struts.chain.contexts.ActionContext;
//import org.apache.struts.chain.contexts.ServletActionContext;
//import org.apache.struts.config.ModuleConfig;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.web.context.WebApplicationContext;
//
//public class AutowireCreateAction extends CreateAction {
//	private static final Log LOG = LogFactory.getLog(CreateAction.class);
//
//	@Override
//	protected Action createAction(ActionContext context, String type) throws Exception {
//		LOG.info("Initializing action of type: " + type);
//		ModuleConfig moduleConfig = context.getModuleConfig();
//		ActionServlet actionServlet = ((ServletActionContext) context).getActionServlet();
//
//		WebApplicationContext webApplicationContext = initWebApplicationContext(actionServlet,
//				moduleConfig);
//		int autowireMode = initAutowireMode(actionServlet);
//		boolean dependencyCheck = initDependencyCheck(actionServlet);
//
//		AutowireCapableBeanFactory beanFactory = webApplicationContext
//				.getAutowireCapableBeanFactory();
//		if (AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR == autowireMode) {
//			Class<?> clazz = ClassUtils.getApplicationClass(type);
//			Action actionBean = (Action) beanFactory.createBean(clazz, autowireMode,
//					dependencyCheck);
//			return actionBean;
//		} else {
//			Action action = super.createAction(context, type);
//			beanFactory.autowireBeanProperties(action, autowireMode, dependencyCheck);
//			return action;
//		}
//	}
//
//	/**
//	 * Fetch ContextLoaderPlugIn's WebApplicationContext from the
//	 * ServletContext, falling back to the root WebApplicationContext. This
//	 * context is supposed to contain the service layer beans to wire the Struts
//	 * Actions with.
//	 * 
//	 * @param actionServlet
//	 *            the associated ActionServlet
//	 * @param moduleConfig
//	 *            the associated ModuleConfig
//	 * @return the WebApplicationContext
//	 * @throws IllegalStateException
//	 *             if no WebApplicationContext could be found
//	 * 
//	 * @see DelegatingActionUtils#findRequiredWebApplicationContext
//	 * @see ContextLoaderPlugIn#SERVLET_CONTEXT_PREFIX
//	 */
//	protected WebApplicationContext initWebApplicationContext(ActionServlet actionServlet,
//			ModuleConfig moduleConfig) throws IllegalStateException {
//
//		WebApplicationContext wac = DelegatingActionUtils.findRequiredWebApplicationContext(
//				actionServlet, moduleConfig);
//		if (wac instanceof ConfigurableApplicationContext) {
//			((ConfigurableApplicationContext) wac).getBeanFactory().ignoreDependencyType(
//					ActionServlet.class);
//		}
//		return wac;
//	}
//
//	/**
//	 * Determine the autowire mode to use for wiring Struts Actions.
//	 * <p>
//	 * The default implementation checks the "autowire" init-param of the Struts
//	 * ActionServlet, falling back to "AUTOWIRE_BY_TYPE" as default.
//	 * 
//	 * @param actionServlet
//	 *            the associated ActionServlet
//	 * @param moduleConfig
//	 *            the associated ModuleConfig
//	 * @return the autowire mode to use
//	 * @see DelegatingActionUtils#getAutowireMode
//	 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#autowireBeanProperties
//	 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#AUTOWIRE_BY_TYPE
//	 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#AUTOWIRE_BY_NAME
//	 */
//	protected int initAutowireMode(ActionServlet actionServlet) {
//		return DelegatingActionUtils.getAutowireMode(actionServlet);
//	}
//
//	/**
//	 * Determine whether to apply a dependency check after wiring Struts
//	 * Actions.
//	 * <p>
//	 * The default implementation checks the "dependencyCheck" init-param of the
//	 * Struts ActionServlet, falling back to no dependency check as default.
//	 * 
//	 * @param actionServlet
//	 *            the associated ActionServlet
//	 * @param moduleConfig
//	 *            the associated ModuleConfig
//	 * @return whether to enforce a dependency check or not
//	 * @see DelegatingActionUtils#getDependencyCheck
//	 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#autowireBeanProperties
//	 */
//	protected boolean initDependencyCheck(ActionServlet actionServlet) {
//		return DelegatingActionUtils.getDependencyCheck(actionServlet);
//	}
//}
