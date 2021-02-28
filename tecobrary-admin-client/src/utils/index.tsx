export function removeHtmlTag(str?: string): string {
  if (!str || (str === ""))
    return "";
  return str.replace(/<[^>]*>/g, "");
}