package com.demo;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		String msg = "5pyq55+l5byC5bi4";
		//5pyq55+l5byC5bi4
		//PFJFUVVFU1RfRlBLSiBjbGFzcz0iUkVRVUVTVF9GUEtKIj4KICA8R0hGTUM+6LSt5pa55ZCN56ewPC9HSEZNQz4KICA8R0hGX05TUlNCSD4xNDAxMTQ5OTk5OTkwNjI8L0dIRl9OU1JTQkg+CiAgPEZLRktIWUhfRktGWUhaSD4xMjM0NTwvRktGS0hZSF9GS0ZZSFpIPgogIDxGS0ZEWl9GS0ZESD4xMjM0NTY3ODkxNDwvRktGRFpfRktGREg+CiAgPFhIRktIWUhfU0tGWUhaSD40NTQ2NDY8L1hIRktIWUhfU0tGWUhaSD4KICA8WEhGRFpfWEhGREg+5aSq5Y6fMDIxMjE1MTU8L1hIRkRaX1hIRkRIPgogIDxGUFpMX0RNPjA8L0ZQWkxfRE0+CiAgPFlGUF9ETT48L1lGUF9ETT4KICA8WUZQX0hNPjwvWUZQX0hNPgogIDxCWj7lpIfms6g8L0JaPgogIDxLUFk+5byA56Wo5Lq6PC9LUFk+CiAgPEZIUj7lpI3moLjkuro8L0ZIUj4KICA8U0tZPuaUtuasvuS6ujwvU0tZPgogIDxYSFFEPjwvWEhRRD4KICA8RlBRUUxTSD5rcGQwNDExMTExMjM0PC9GUFFRTFNIPgogIDxLUExYPjE8L0tQTFg+CiAgPEpTSEo+MzUxLjA8L0pTSEo+CiAgPEhKSkU+MzAwLjA8L0hKSkU+CiAgPEhKU0U+NTEuMDwvSEpTRT4KICA8RlBfS0pNWFMgY2xhc3M9IkZQX0tKTVg7IiBzaXplPSIyIj4KICAgIDxGUF9LSk1YPgogICAgICA8U1BNQz7pobnnm67lkI3np7AxPC9TUE1DPgogICAgICA8U00+PC9TTT4KICAgICAgPFNMPjAuMTc8L1NMPgogICAgICA8R0dYSD7kuKo8L0dHWEg+CiAgICAgIDxKTERXPuS4qjwvSkxEVz4KICAgICAgPFNQU0w+MS4wPC9TUFNMPgogICAgICA8U1BESj4xMDAuMDwvU1BESj4KICAgICAgPFNQSkU+MTAwLjA8L1NQSkU+CiAgICAgIDxGUEhYWj4wPC9GUEhYWj4KICAgICAgPEhTSkJaPjA8L0hTSkJaPgogICAgICA8U0U+MTcuMDwvU0U+CiAgICA8L0ZQX0tKTVg+CiAgICA8RlBfS0pNWD4KICAgICAgPFNQTUM+6aG555uu5ZCN56ewMjwvU1BNQz4KICAgICAgPFNNPjwvU00+CiAgICAgIDxTTD4wLjE3PC9TTD4KICAgICAgPEdHWEg+5Y+wPC9HR1hIPgogICAgICA8SkxEVz7lj7A8L0pMRFc+CiAgICAgIDxTUFNMPjIuMDwvU1BTTD4KICAgICAgPFNQREo+MTAwLjA8L1NQREo+CiAgICAgIDxTUEpFPjIwMC4wPC9TUEpFPgogICAgICA8RlBIWFo+MDwvRlBIWFo+CiAgICAgIDxIU0pCWj4wPC9IU0pCWj4KICAgICAgPFNFPjM0LjA8L1NFPgogICAgPC9GUF9LSk1YPgogIDwvRlBfS0pNWFM+CjwvUkVRVUVTVF9GUEtKPg==
		String result = new String(new BASE64Decoder().decodeBuffer(msg));
		System.out.println(result);
		
	}
}
