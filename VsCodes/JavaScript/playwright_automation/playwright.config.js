// @ts-check
const { defineConfig} = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests',
  reporter: 'html',
  timeout:30000,
  expect:{
    timeout:5000
  },
  use: {
    browserName:'webkit',
    headless:false,
  },

});

