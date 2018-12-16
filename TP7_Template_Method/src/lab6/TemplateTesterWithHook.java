package lab6;
public class TemplateTesterWithHook {
	public static void main(String[] args) {
		AbstractTemplateWithHook temp = new ConcreteTemplateWithHook();
		temp.templateMethod();
	}

}
