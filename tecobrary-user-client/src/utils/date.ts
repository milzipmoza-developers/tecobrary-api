export const parseDate = (dateString: string): string => {
  const date: Date = new Date(dateString);
  const year = date.getFullYear();
  const month = (1 + date.getMonth());
  const day = date.getDate();
  return `${year}년 ${month}월 ${day}일`
}