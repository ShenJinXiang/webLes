package com;

import com.qysoft.utils.Base64Util;

public class demo {

	public static void main(String[] args) {
		String str = "5Luj56CB77yaMTAyMSzplJnor6/vvJrlvIDnpajkurrplb/luqbmnIDlpKfkuI3og73otoXov4c45Liq5a2X6IqCKOaxieWtl+aIluWFqOinkuWtl+espuWNoDLkuKrlrZfoioLvvIzlrZfmr43mlbDlrZfmiJbljYrop5LlrZfnrKbljaAx5Liq5a2X6IqCKSjnjovpuY/po57lkbXlkbVhanNkbGZqbHNqZmxzZGpmbHNkamZsamRza2xmamRzbGtmamwp";
		String result = Base64Util.decode(str);
		System.out.println(result);
	}
}
