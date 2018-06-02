package com.spel;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpEL提供简单的接口从而简化用户使用，在介绍原理前让我们学习下几个概念：
 * 一、表达式：表达式是表达式语言的核心，所以表达式语言都是围绕表达式进行的，从我们角度来看是“干什么”；
 * 二、解析器：用于将字符串表达式解析为表达式对象，从我们角度来看是“谁来干”；
 * 三、上下文：表达式对象执行的环境，该环境可能定义变量、定义自定义函数、提供类型转换等等，从我们角度看是“在哪干”；
 * 四、根对象及活动上下文对象：根对象是默认的活动上下文对象，活动上下文对象表示了当前表达式操作的对象，从我们角度看是“对谁干”
 * 
 * @author Administrator
 * 
 */
public class SpELTest {
	/**
	 * 1）创建解析器：SpEL使用ExpressionParser接口表示解析器，提供SpelExpressionParser默认实现；
	 * 2）解析表达式：使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象。
	 * 3）构造上下文：准备比如变量定义等等表达式需要的上下文数据。 4）求值：通过Expression接口的getValue方法根据上下文获得表达式值。
	 */
	@Test
	public void helloWorld() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser
				.parseExpression("('Hello' + ' World').concat(#end)");
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("end", "!");
		Assert.assertEquals("Hello World!", expression.getValue(context));
	}

	@Test
	public void testPa() {
		ExpressionParser parser = new SpelExpressionParser();
		ParserContext parserContext = new ParserContext() {
			@Override
			public boolean isTemplate() {
				return true;
			}

			@Override
			public String getExpressionPrefix() {
				return "#{";
			}

			@Override
			public String getExpressionSuffix() {
				return "}";
			}
		};
		String template = "#{'Hello '}#{'World!'}";
		Expression expression = parser.parseExpression(template, parserContext);
		Assert.assertEquals("Hello World!", expression.getValue());
		System.out.println(expression.getValue());
	}
}
