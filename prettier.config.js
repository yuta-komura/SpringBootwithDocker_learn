module.exports = {
  printWidth: 80,             // 1行の最大文字数（これ以上の文字数は改行される）
  tabWidth: 2,                // インデントのスペース数（2スペースを使用）
  useTabs: false,             // タブではなくスペースを使用
  semi: true,                 // 行末にセミコロンを付ける
  singleQuote: true,          // シングルクォートを使用
  trailingComma: "es5",       // ES5に準拠した末尾のカンマ（オブジェクトや配列の最後にカンマを付ける）
  bracketSpacing: true,       // オブジェクトリテラルの中括弧内にスペースを追加
  jsxSingleQuote: false,      // JSXでダブルクォートを使用
  arrowParens: "always",      // アロー関数の引数が1つの場合でも括弧を付ける
  endOfLine: "lf",            // 改行コードをLFに統一
  plugins: ["prettier-plugin-sql"],  // SQLフォーマット用のプラグイン
};
