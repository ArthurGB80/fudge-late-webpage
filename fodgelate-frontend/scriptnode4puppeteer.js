(async () => {
  const puppeteer = require('puppeteer');
  const browser = await puppeteer.launch();
  console.log(await browser.version());
  await browser.close();
})();
