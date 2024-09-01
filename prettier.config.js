module.exports = {
  // 1行の最大文字数（これ以上の文字数は改行される）
  printWidth: 80,
  // インデントのスペース数（2スペースを使用）
  tabWidth: 2,
  // タブではなくスペースを使用
  useTabs: false,
  // 行末にセミコロンを付ける
  semi: true,
  // シングルクォートを使用
  singleQuote: true,
  // ES5に準拠した末尾のカンマ（オブジェクトや配列の最後にカンマを付ける）
  trailingComma: 'es5',
  // オブジェクトリテラルの中括弧内にスペースを追加
  bracketSpacing: true,
  // JSXでダブルクォートを使用
  jsxSingleQuote: false,
  // アロー関数の引数が1つの場合でも括弧を付ける
  arrowParens: 'always',
  // 改行コードをLFに統一
  endOfLine: 'lf',
  // SQLフォーマット用のプラグイン
  plugins: ['prettier-plugin-sql'],
};
