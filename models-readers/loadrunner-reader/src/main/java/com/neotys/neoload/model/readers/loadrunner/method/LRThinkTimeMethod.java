package com.neotys.neoload.model.readers.loadrunner.method;

import com.google.common.base.Preconditions;
import com.neotys.neoload.model.core.Element;
import com.neotys.neoload.model.parsers.CPP14Parser.MethodcallContext;
import com.neotys.neoload.model.readers.loadrunner.LoadRunnerVUVisitor;
import com.neotys.neoload.model.readers.loadrunner.MethodCall;
import com.neotys.neoload.model.repository.ImmutableDelay;

public class LRThinkTimeMethod  implements LoadRunnerMethod {
	
	public LRThinkTimeMethod() {
		super();
	}

	@Override
	public Element getElement(LoadRunnerVUVisitor visitor, MethodCall method, MethodcallContext ctx) {
		Preconditions.checkNotNull(method);		
		Preconditions.checkNotNull(method.getParameters(), method.getName() + " method must have a parameter");
		Preconditions.checkArgument(!method.getParameters().isEmpty(), method.getName() + " method must have a parameter");		
		
		String delayInMs = method.getParameters().get(0) + "000";
		visitor.readSupportedFunction(method.getName(), ctx);		
		return ImmutableDelay.builder().name("delay").delay(delayInMs).isThinkTime(true).build();
	}

}
