package vo;

public class AdminScheduleInfo {
	// 일정 관리의 달력에서 필요한 정보들을 저장할 클래스
		private int year, month, day, cYear, cMonth, cDay;
		// 검색 연도, 검색 월, 검색 일, 현재 연도, 현재 월, 현재 일

		public int getYear() {
			return year;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getcYear() {
			return cYear;
		}

		public void setcYear(int cYear) {
			this.cYear = cYear;
		}

		public int getcMonth() {
			return cMonth;
		}

		public void setcMonth(int cMonth) {
			this.cMonth = cMonth;
		}

		public int getcDay() {
			return cDay;
		}

		public void setcDay(int cDay) {
			this.cDay = cDay;
		}
		
		
	}

