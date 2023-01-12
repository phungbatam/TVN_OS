/**
 * Copyright (C) 2022 By Super coder <pbyt998@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://github.com/phungbatam/TVN_OS
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bennavetta.jconsole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CachingCompletionSource implements CompletionSource
{
	private Map<String, List<String>> completionCache = new HashMap<String, List<String>>();
	
	public List<String> complete(String text)
	{
		if(completionCache.containsKey(text))
		{
			return completionCache.get(text);
		}
		else
		{
			List<String> results = doCompletion(text);
			completionCache.put(text, results);
			return results;
		}
	}
	
	protected abstract List<String> doCompletion(String input);
}
