/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleDTRules.Classes;

/**
 *
 * @author NazonaX
 */
public class Result {
    private int ResultCode;
    private String ResultMessage;
    private Object EX1;
    private Object Ex2;

    /**
     * @return the ResultCode
     */
    public int getResultCode() {
        return ResultCode;
    }

    /**
     * @param ResultCode the ResultCode to set
     */
    public void setResultCode(int ResultCode) {
        this.ResultCode = ResultCode;
    }

    /**
     * @return the ResultMessage
     */
    public String getResultMessage() {
        return ResultMessage;
    }

    /**
     * @param ResultMessage the ResultMessage to set
     */
    public void setResultMessage(String ResultMessage) {
        this.ResultMessage = ResultMessage;
    }

    /**
     * @return the EX1
     */
    public Object getEX1() {
        return EX1;
    }

    /**
     * @param EX1 the EX1 to set
     */
    public void setEX1(Object EX1) {
        this.EX1 = EX1;
    }

    /**
     * @return the Ex2
     */
    public Object getEx2() {
        return Ex2;
    }

    /**
     * @param Ex2 the Ex2 to set
     */
    public void setEx2(Object Ex2) {
        this.Ex2 = Ex2;
    }
}
