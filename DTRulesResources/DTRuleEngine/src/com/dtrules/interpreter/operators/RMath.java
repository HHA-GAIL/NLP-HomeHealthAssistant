/** 
 * Copyright 2004-2011 DTRules.com, Inc.
 * 
 * See http://DTRules.com for updates and documentation for the DTRules Rules Engine  
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");  
 * you may not use this file except in compliance with the License.  
 * You may obtain a copy of the License at  
 *   
 *      http://www.apache.org/licenses/LICENSE-2.0  
 *   
 * Unless required by applicable law or agreed to in writing, software  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 * See the License for the specific language governing permissions and  
 * limitations under the License.  
 **/
  
package com.dtrules.interpreter.operators;

import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import com.dtrules.interpreter.RDouble;
import com.dtrules.interpreter.RInteger;
import com.dtrules.interpreter.RString;
import com.dtrules.session.DTState;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * Defines math operators.
 * @author paul snow
 *
 */
public class RMath {
    static {
        new Add();      new Mul();        new Sub();        new Div();
        new FAdd();     new FMul();       new FSub();       new FDiv();
        new Abs();      new Negate();
        new FAbs();     new FNegate();
        new Roundto();  
        new MyAdd();    new CallFunction();     //Turbo
    }
    
    /**
     * ( number #places boundary -- number2 )
     * The number of decimal places would be zero to round to the nearest 
     * integer, 1 to the nearest 10th, -1 to the nearest 10. The boundary 
     * is the value added to the lower fractional amount to trigger the 
     * round.  In other words, <br><br>
     * 
     * 1.3 0 .7 roundto<br><br>
     * 
     * would result in 1, while<br><br>
     * 
     * 1.7 0 .7 roundto<br>
     * 
     * would reslut in 2.<br><br><br>
     * 
     * Note:  if the boundary is zero, than any fractional amount will round up.  
     * If the boundary is 1, the number is simply truncated.
     * 
     * Limitation:  We always towards zero.  Lots of other rounding ideas are
     * possible.  We need to come back here and rework and add to our options
     * if the need for more complexity comes our way.
     * 
     * @author paul snow
     *
     */
    public static class Roundto extends ROperator {
        Roundto(){super("roundto"); }
        
        double round(double number,double boundary){
            double v = (int)number;                 // Get the integer porition of number
            if (boundary>=1) return v;              // If boundary is 1 or greater we are done
            double r = Math.abs(number - v);        // Get the fractional portion of number
            if (boundary<=0) return r>0 ? v++ : v;  // If boundary is 0 or less, inc on any fraction
            if(r>=boundary)return v++;              // Otherwise test the boundary.  Inc if fraction
            return v;                               //    is greater or equal to the boundary.
        }
        public void execute(DTState state)throws RulesException {
            double boundary = state.datapop().doubleValue();
            int    places   = state.datapop().intValue();
            double number   = state.datapop().doubleValue();
            if(places >0){                          // We put the boundary across zero. shift left if
                number *= 10*places;                //    places is positive (okay, its a decimal shift)
                number = round(number,boundary);    // Do the round thing.
                number /= 10*places;                // Fix it back when done.
            }else{
                number /= -10*places;               // We decimal shift right if places is negative
                number = round(number,boundary);    // Do the round thing
                number *= -10*places;               // Fix it back.
            }
            
        }
    }
    
    
    /**
     * Negate a double
     * @author paul snow
     *
     */
    public static class FNegate extends ROperator {
        FNegate(){super("fnegate"); }
        
        public void execute(DTState state)throws RulesException {
            state.datapush(
              RDouble.getRDoubleValue(
                 -state.datapop().doubleValue()
              )
            );
        }
    }
    
    
    /**
     * Absolute value of a double.
     * @author paul snow
     *
     */
    public static class FAbs extends ROperator {
        FAbs(){super("fabs"); }
        
        public void execute(DTState state)throws RulesException {
            state.datapush(
              RDouble.getRDoubleValue(
                 Math.abs(state.datapop().doubleValue())
              )
            );
        }
    }
    /**
     * Absolute value of an integer
     * @author paul snow
     *
     */
    public static class Abs extends ROperator {
        Abs(){super("abs"); }
        
        public void execute(DTState state)throws RulesException {
            state.datapush(
              RInteger.getRIntegerValue(
                 Math.abs(state.datapop().intValue())
              )
            );
        }
    }
    
    /**
     * Negate an integer
     * @author paul snow
     *
     */
    public static class Negate extends ROperator {
        Negate(){super("negate"); }
        
        public void execute(DTState state)throws RulesException {
            state.datapush(
              RInteger.getRIntegerValue(
                 -state.datapop().intValue()
              )
            );
        }
    }    

    /**
     * Add Operator, adds two integers
     * @author Paul Snow
     *
     */
	public static class Add extends ROperator {
		Add(){
			super("+"); alias("ladd");
		}

		public void execute(DTState state) throws RulesException {
			state.datapush(RInteger.getRIntegerValue(state.datapop().longValue()+state.datapop().longValue()));
		}
	}
	
	
	
	
	/**
	 * Sub Operator, subracts two integers
	 * @author Paul Snow
	 *
	 */
	public static class Sub extends ROperator {
		Sub(){super("-"); alias("lsub");}

		public void execute(DTState state) throws RulesException {
			long b = state.datapop().longValue();
			long a = state.datapop().longValue();
			long result = a-b;
			state.datapush(RInteger.getRIntegerValue(result));
		}
	}

	/**
	 * Mul Operator, multiply two integers
	 * @author Paul Snow
	 *
	 */
	public static class Mul extends ROperator {
		Mul(){super("*"); alias("lmul");}

		public void execute(DTState state) throws RulesException {
			state.datapush(RInteger.getRIntegerValue(state.datapop().longValue()*state.datapop().longValue()));
		}
	}

	/**
	 * Divide Operator, divides one integer by another
	 * @author Paul Snow
	 *
	 */
	public static class Div extends ROperator {
		Div(){super("/"); alias("div"); alias("ldiv");}

		public void execute(DTState state) throws RulesException {
			long result;
			long a=0; long b=0;
			try {
				b = state.datapop().longValue();
				a = state.datapop().longValue();
				result = a/b;
			} catch (ArithmeticException e) {
				throw new RulesException("Math Exception","/","Error in Divide: "+a+"/"+b+"\n"+e);
			}
			state.datapush(RInteger.getRIntegerValue(result));
		}
	}
	
    /**
     * FAdd (f+) Operator, adds two doubles
     * @author Paul Snow
     *
     */
    public static class FAdd extends ROperator {
        FAdd(){
            super("f+");alias("fadd");
        }

        public void execute(DTState state) throws RulesException {
            IRObject b = state.datapop();
            IRObject a = state.datapop();
            state.datapush(RDouble.getRDoubleValue(a.doubleValue()+b.doubleValue()));
        }
    }
    
    
    
    
    /**
     * FSub (f-) Operator, subracts two doubles
     * @author Paul Snow
     *
     */
    public static class FSub extends ROperator {
        FSub(){super("f-");alias("fsub");}

        public void execute(DTState state) throws RulesException {
            double b = state.datapop().doubleValue();
            double a = state.datapop().doubleValue();
            double result = a-b;
            state.datapush(RDouble.getRDoubleValue(result));
        }
    }

    /**
     * FMul Operator, multiply two doubles
     * @author Paul Snow
     *
     */
    public static class FMul extends ROperator {
        FMul(){super("f*");alias("fmul");}

        public void execute(DTState state) throws RulesException {
            IRObject d2 = state.datapop();
            IRObject d1 = state.datapop();
            state.datapush(RDouble.getRDoubleValue(d1.doubleValue()*d2.doubleValue()));
        }
    }

    /**
     * FDiv Operator, divides one double by another double.
     * @author Paul Snow
     *
     */
    public static class FDiv extends ROperator {
        FDiv(){super("fdiv"); alias("f/");}

        public void execute(DTState state) throws RulesException {
            double result;
            double a=0; double b=0;
            try {
                b = state.datapop().doubleValue();
                a = state.datapop().doubleValue();
                result = a/b;
            } catch (ArithmeticException e) {
                throw new RulesException("Math Exception","f/","Error in Divide: "+a+"/"+b+"\n"+e);
            }
            state.datapush(RDouble.getRDoubleValue(result));
        }
    }
    
    /**
     * Add Operator, adds two doubles
     * @author Turbo
     *
     */
	public static class MyAdd extends ROperator {
		MyAdd(){
			super("myadd"); alias("m+");
		}

		public void execute(DTState state) throws RulesException {
			state.datapush(RDouble.getRDoubleValue(state.datapop().doubleValue()+state.datapop().doubleValue()));
		}
	}
	
    /**
     * CallFunction Operator, call an existed function
     * @author Turbo
     *
     */
	public static class CallFunction extends ROperator {
		CallFunction(){
			super("callfunction"); alias("call");
		}

		public void execute(DTState state) throws RulesException {
            Object result;
            String a; String b;
            try {
                String funcString = state.datapop().stringValue();
                
                int indexLess = funcString.indexOf("<");
                if (indexLess < 0)
                {
                	throw new Exception("must provide parameter type, such as fun<int, double>(1,2.2)");
                }
                String firstPart = funcString.substring(0, indexLess).trim();
                int i = firstPart.lastIndexOf(".");
                String classNameString;
                String methodString;
                if (i>=0)
                {
                classNameString=firstPart.substring(0, i).trim(); //get the class name
                methodString = firstPart.substring(i+1).trim(); // get the method name
                }
                else
                {
                    classNameString = "dhu.edu.lib.Utils";  //specify the class name
                    methodString = firstPart;   //only a method name
                }
               
                String parameterTypeString =funcString.substring(indexLess+1, funcString.indexOf(">")).trim();//截取参数类型
                List<String> paramTypeList =Arrays.asList(parameterTypeString.split(","));
                
                
                String parameterString=funcString.substring(funcString.indexOf("(")+1,funcString.lastIndexOf(")")).trim();//截取参数
                List<String> paramList0=Arrays.asList(parameterString.split(","));
                List paramList = new ArrayList(paramList0);
                char  item1 ;
                char  item2 ;
                int j=0;       //非局部循环变量
                String s;      //加工字符串中间变量
                //处理字符串参数方法
                while (j<paramList.size()) {
                    String aParam = paramList.get(j).toString().trim();
                    item1 =aParam.charAt(0);
                    item2 =aParam.charAt(aParam.length()-1);
                   //if(item1=='\"'&&item2!='\"')
                    if(item1=='\''&&item2!='\'')
                   {                
                   s=paramList.get(j).toString();
                   s+=","+paramList.get(j+1);
                   paramList.set(j, s);
                   paramList.remove(j+1);
                  }else{
                     j++;               
                   }
                }

                if (paramList.size() < paramTypeList.size())
                {
                	throw new Exception("should provide enough parameters");
                }
                 Class[] classes =new  Class[paramTypeList.size()];//参数类型集合
                 
                 //参数类型加工
                 for (int k = 0; k <classes.length; k++) {
                     if(null != paramTypeList.get(k))
                         switch (paramTypeList.get(k).trim().toLowerCase()) {
                        case "double":
                            classes[k]=double.class;
                            paramList.set(k, Double.parseDouble(((String) paramList.get(k)).trim()));
                            break;
                        case "string":
                            classes[k]=String.class;
                            paramList.set(k, ((String) paramList.get(k)).trim().substring(1, ((String) paramList.get(k)).trim().length()-1));
                            break;
                        case "int":
                            classes[k]=int.class;
                            paramList.set(k, Integer.parseInt(((String) paramList.get(k)).trim()));
                            break;
                        case "char":
                        	classes[k]=char.class;
                        	paramList.set(k,  ((String) paramList.get(k)).trim().charAt(1));
                        	break;
                        default:
                            throw new Exception("parameter type wrong,only double, string, int, char are allowed");                 
                    }
                }
                 
                 //Class c = urlClassLoader.loadClass("dhu.edu.lib."+classNameString);     
                 Class c = Class.forName(classNameString);
                 java.lang.reflect.Method m = c.getMethod(methodString,classes);  
                 
                 //具体参数个数入口
                 switch(classes.length){
                    case 0:
                    result = m.invoke(null);
                    break;
                    case 1:
                    result = m.invoke(null, paramList.get(0));
                    break;
                    case 2:
                    result = m.invoke(null, paramList.get(0),paramList.get(1));
                    break;
                    case 3:
                    result = m.invoke(null, paramList.get(0),paramList.get(1),paramList.get(2));
                    break;
                    case 4:
                    result = m.invoke(null, paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3));
                    break;
                    case 5:
                    result = m.invoke(null, paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4));
                    break;
                    case 6:
                    result = m.invoke(null, paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4),paramList.get(5));
                    break;
                    case 7:
                    result = m.invoke(null,paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4),paramList.get(5),paramList.get(6));
                    break;
                    case 8:
                    result = m.invoke(null, paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4),paramList.get(5),paramList.get(6),paramList.get(7));
                    break;
                    case 9:
                    result = m.invoke(null,paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4),paramList.get(5),paramList.get(6),paramList.get(7),paramList.get(8));
                    break;
                    case 10:
                    result = m.invoke(null,paramList.get(0),paramList.get(1),paramList.get(2),paramList.get(3),paramList.get(4),paramList.get(5),paramList.get(6),paramList.get(7),paramList.get(8),paramList.get(9));
                    break;
                   default:
                       result = "too many parameters, maximum is 10";
                    break;
                 }
            } catch (Exception e) {
                result = "Exception in CallFunction:  "+e;
            }
            state.datapush(RString.newRString(result.toString()));		
            }
	}
}
