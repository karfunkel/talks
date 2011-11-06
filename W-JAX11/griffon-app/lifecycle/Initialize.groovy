/*
 * This script is executed inside the UI thread, so be sure to  call 
 * long running code in another thread.
 *
 * You have the following options
 * - execOutside { // your code }
 * - execFuture { // your code }
 * - Thread.start { // your code }
 *
 * You have the following options to run code again inside the UI thread
 * - execAsync { // your code }
 * - execSync { // your code }
 */

import groovy.swing.SwingBuilder
import static griffon.util.GriffonApplicationUtils.isMacOSX
import java.awt.Font
import javax.swing.UIManager
import java.awt.Color
import com.sun.java.swing.Painter
import fishygames.ui.FishyBorder
import java.awt.Insets
import fishygames.ui.FishyPainters
import javax.swing.plaf.FontUIResource
import javax.swing.plaf.ColorUIResource

SwingBuilder.lookAndFeel('nimbus')
