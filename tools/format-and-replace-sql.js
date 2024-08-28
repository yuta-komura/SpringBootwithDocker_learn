const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

// 置換対象の SQL ファイルをコマンドライン引数から取得
const filePath = process.argv[2];

if (!filePath) {
  console.error('Error: No file path provided.');
  process.exit(1);
}

// ファイルが存在するか確認
if (!fs.existsSync(filePath)) {
  console.error(`Error: File ${filePath} does not exist.`);
  process.exit(1);
}

// SQL ファイルをフォーマットする関数
function formatSqlFile(filePath) {
  try {
    execSync(`npx prettier --write "${filePath}"`, { stdio: 'inherit' });
    console.log(`Formatted: ${filePath}`);
  } catch (error) {
    console.error(`Error formatting file: ${filePath}`, error);
  }
}

// 文字列を置き換える関数
function replaceInFile(filePath, search, replace) {
  let data = fs.readFileSync(filePath, 'utf8');
  data = data.replace(new RegExp(search, 'g'), replace);
  // 改行コードを \n に変換
  data = data.replace(/\r\n/g, '\n');
  fs.writeFileSync(filePath, data, 'utf8');
  console.log(`Replaced content in: ${filePath}`);
}

// スクリプト実行
function main() {
  formatSqlFile(filePath); // SQL ファイルのフォーマット
  replaceInFile(filePath, '\\*/ ', '*/'); // SQL ファイルの置換処理
}

main();
