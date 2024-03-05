package com.AchintyaNigam.demo;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EvaluationController {

	@PostMapping("/evaluate")
    public ApiResponse evaluateExpression(@RequestParam String expression, @RequestParam boolean DEG) {
        try {
        	//!for '^' make sure the request has '%5E' instead!
            double result = evaluate(expression, DEG);
            return new ApiResponse(result);
        } catch (Exception e) {
            return new ApiResponse("Error: Invalid expression");
        }
    }

    private static double evaluate(String expression, boolean DEG) {
        Map<String, Double> allVariables = new HashMap<>();
        allVariables.put("pi", Math.PI);
        allVariables.put("e", Math.E);

        // Define custom functions using exp4j's Function interface
        Function lnFunction = new Function("ln", 1) {
            @Override
            public double apply(double... args) {
            	
                return Math.log(args[0]);
            }
        };
        
        Function log10Function = new Function("log10", 1) {
            @Override
            public double apply(double... args) {
                return Math.log10(args[0]);
            }
        };
        
        Function logBaseYFunction = new Function("logBaseY", 2) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0]) / Math.log(args[1]);
            }
        };
        
        Function cbrtFunction = new Function("cbrt", 1) {
            @Override
            public double apply(double... args) {
                return Math.cbrt(args[0]);
            }
        };
        
     
        Function factFunction = new Function("fact", 1) {
            @Override
            public double apply(double... args) {
                int n = (int) args[0];
                if (n < 0 || n != (int) args[0]) {
                    throw new IllegalArgumentException("Factorial is defined for non-negative integers only.");
                }
                return factorial(n);
            }

            private int factorial(int n) {
                return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
            }
        };
         
        
        Function sinFunction = new Function("sin", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.sin(Math.toRadians(args[0]));
            	}
                return Math.sin(args[0]);
            }
        };
        
        Function cosFunction = new Function("cos", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return Math.cos(Math.toRadians(args[0]));
            	}
                return Math.cos(args[0]);
            }
        };
        
        Function tanFunction = new Function("tan", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return Math.tan(Math.toRadians(args[0]));
            	}
                return Math.tan(args[0]);
            }
        };
        
        Function cosecFunction = new Function("cosec", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.sin(Math.toRadians(args[0]));
            	}
                return 1/Math.sin(args[0]);
            }
        };
        
        Function secFunction = new Function("sec", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.cos(Math.toRadians(args[0]));
            	}
                return 1/Math.cos(args[0]);
            }
        };
        
        Function cotFunction = new Function("cot", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.tan(Math.toRadians(args[0]));
            	}
                return 1/Math.tan(args[0]);
            }
        };
        
        Function asinFunction = new Function("asin", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.asin(Math.toRadians(args[0]));
            	}
                return Math.asin(args[0]);
            }
        };
        
        Function acosFunction = new Function("acos", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.acos(Math.toRadians(args[0]));
            	}
                return Math.acos(args[0]);
            }
        };
        
        Function atanFunction = new Function("atan", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.atan(Math.toRadians(args[0]));
            	}
                return Math.atan(args[0]);
            }
        };
        
        Function acosecFunction = new Function("acosec", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.asin(Math.toRadians(args[0]));
            	}
                return 1/Math.asin(args[0]);
            }
        };
        
        Function asecFunction = new Function("asec", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.acos(Math.toRadians(args[0]));
            	}
                return 1/Math.acos(args[0]);
            }
        };
        
        Function acotFunction = new Function("acot", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		return 1/Math.atan(Math.toRadians(args[0]));
            	}
                return 1/Math.atan(args[0]);
            }
        };
        
        Function sinhFunction = new Function("sinh", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.sinh(Math.toRadians(args[0]));
            	}
                return Math.sinh(args[0]);
            }
        };

        Function coshFunction = new Function("cosh", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.cosh(Math.toRadians(args[0]));
            	}
                return Math.cosh(args[0]);
            }
        };

        Function tanhFunction = new Function("tanh", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return Math.tanh(Math.toRadians(args[0]));
            	}
                return Math.tanh(args[0]);
            }
        };
        
        Function cosechFunction = new Function("cosech", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return 1/Math.sinh(Math.toRadians(args[0]));
            	}
                return 1/Math.sinh(args[0]);
            }
        };

        Function sechFunction = new Function("sech", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return 1/Math.cosh(Math.toRadians(args[0]));
            	}
                return 1/Math.cosh(args[0]);
            }
        };

        Function cothFunction = new Function("tanh", 1) {
            @Override
            public double apply(double... args) {
            	if(DEG)
            	{
            		 return 1/Math.tanh(Math.toRadians(args[0]));
            	}
                return 1/Math.tanh(args[0]);
            }
        };

        Function asinhFunction = new Function("asinh", 1) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0] + Math.sqrt(args[0] * args[0] + 1));
            }
        };

        Function acoshFunction = new Function("acosh", 1) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0] + Math.sqrt(args[0] * args[0] - 1));
            }
        };

        Function atanhFunction = new Function("atanh", 1) {
            @Override
            public double apply(double... args) {
                return 0.5 * Math.log((1 + args[0]) / (1 - args[0]));
            }
        };
        
        Function acosechFunction = new Function("acosech", 1) {
            @Override
            public double apply(double... args) {
                return 1/(Math.log(args[0] + Math.sqrt(args[0] * args[0] + 1)));
            }
        };

        Function asechFunction = new Function("asech", 1) {
            @Override
            public double apply(double... args) {
                return 1/(Math.log(args[0] + Math.sqrt(args[0] * args[0] - 1)));
            }
        };

        Function acothFunction = new Function("acoth", 1) {
            @Override
            public double apply(double... args) {
                return 1/(0.5 * Math.log((1 + args[0]) / (1 - args[0])));
            }
        };
        
        Function absFunction = new Function("abs", 1) {
        	@Override
        	public double apply(double... args) {
        		return Math.abs(args[0]);
        	}
        };
        
        Function floorFunction = new Function("floor", 1) {
        	@Override
        	public double apply(double... args) {
        		return Math.floor(args[0]);
        	}
        };
        
        Function ceilFunction = new Function("ceil", 1) {
        	@Override
        	public double apply(double... args) {
        		return Math.ceil(args[0]);
        	}
        };
        

        // Add custom functions to the expression builder
        Expression exp = new ExpressionBuilder(expression)
                .variables(allVariables.keySet())
                .functions(
                		log10Function, 
                		lnFunction, 
                		logBaseYFunction, 
                		cbrtFunction, 
                		factFunction, 
                		
                		sinFunction, 
                		cosFunction, 
                		tanFunction, 
                		secFunction, 
                		cosecFunction, 
                		cotFunction,
                		
                		asinFunction, 
                		acosFunction, 
                		atanFunction, 
                		asecFunction, 
                		acosecFunction, 
                		acotFunction,
                		
                		sinhFunction, 
                		coshFunction, 
                		tanhFunction, 
                		sechFunction, 
                		cosechFunction, 
                		cothFunction,
                		
                		asinhFunction, 
                		acoshFunction, 
                		atanhFunction, 
                		asechFunction, 
                		acosechFunction, 
                		acothFunction,
                		
                		absFunction,
                		floorFunction,
                		ceilFunction
                		)
                .build()
                .setVariables(allVariables);

        return exp.evaluate();
    }
    
    static class ApiResponse {
        private final Object result;

        public ApiResponse(Object result) {
            this.result = result;
        }

        public Object getResult() {
            return result;
        }
    }
}
