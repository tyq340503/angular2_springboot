
var webpack = require('webpack');
var path = require('path');
var HtmlwebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: "./src/main.ts",
    output: {
        //制定打包后的输出文件名,这个文件需要被引入到index.html中
        path: path.resolve(__dirname, 'dist'),
        filename: "./bundle.js"
    },
    resolve: {
        root: [path.join(__dirname, 'src')],
        extensions: ['', '.ts', '.js']
    },
    module: {

        loaders: [
            { test: /\.ts$/, loader: 'ts-loader' },
            { test: /\.css$/, loader: 'css-loader' }
        ]
    },
    plugins: [
        // plugins
        new HtmlwebpackPlugin({
            template: path.resolve(__dirname, 'src/index.html'),
            inject: 'body'
        })
    ],
};

// var webpack = require('webpack');
// var path = require('path');
// var HtmlwebpackPlugin = require('html-webpack-plugin');
// var config = {
//     // 入口
//     entry: ['babel-polyfill', './src/main.ts'],
//     // 生成的文件
//     output: {
//         path: path.resolve(__dirname, 'dist'),
//         filename: 'bundle.js'
//     },
//     // 文件后缀
//     resolve: {
//         extensions: ['', '.ts', '.js']
//     },
//     module: {
//         // babel
//         // loader: [
//         //     { test: /\.ts$/, loader: 'ts-loader' }
//         // ],
//         rules: [
//             {
//                 test: /\.ts$/,
//                 // include: [/src.main/],
//                 loaders: 'awesome-typescript-loader',
//                 // use: ["babel-loader", "awesome-typescript-loader?silent=true" , "ts-loader" , "angular2-template-loader"],
//                 exclude: /node_modules/
//             },
//             {
//                 test: /\.css$/, // Only .css files
//                 use: ["style-loader", "css-loader"]
//             }]
//     },
//     plugins: [
//         // plugins
//         new HtmlwebpackPlugin({
//             template: path.resolve(__dirname, 'src/index.html'),
//             inject: 'body'
//         })
//     ],
//     devtool: 'source-map'
// };
// module.exports = config;