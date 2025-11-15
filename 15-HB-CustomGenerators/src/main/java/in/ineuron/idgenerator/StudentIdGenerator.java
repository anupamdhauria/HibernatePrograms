package in.ineuron.idgenerator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		System.out.println("StudentIdGenerator.generate()");
		String id="IN-01";
		return id;
	}

}
