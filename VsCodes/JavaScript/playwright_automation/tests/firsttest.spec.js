const {test}=require('@playwright/test');

test.only('My first test in playwright',async({browser})=>{

    const context=await browser.newContext();
    const page=await context.newPage();

    await page.goto('https://omayo.blogspot.com/')
    await page.locator('.gsc-input .gsc-input').fill('Happy Coding')
    await page.locator('input.gsc-search-button').click()

});