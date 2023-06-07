package fr.sylvainjanet.app.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Initial data class.
 * 
 * @author Sylvain
 *
 */
public final class InitialData {

  /**
   * Initial text in db.
   */
  public static final List<LocalizedString> INIT_LOCALIZED_STRING =
      Collections.unmodifiableList(Arrays.asList(new LocalizedString(
          Arrays.asList("sylvain-janet"), new HashMap<TextLanguage, String>() {
            /**
             * Id for serialization.
             */
            private static final long serialVersionUID = 5329903716971275346L;

            {
              put(TextLanguage.FRENCH, "Sylvain Janet");
              put(TextLanguage.ENGLISH, "Sylvain Janet");
            }
          }), new LocalizedString(Arrays.asList("french-language-name"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -8150612809357275996L;

                {
                  put(TextLanguage.FRENCH, "Français");
                  put(TextLanguage.ENGLISH, "French");
                }
              }),
          new LocalizedString(Arrays.asList("english-language-name"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Anglais");
                  put(TextLanguage.ENGLISH, "English");
                }
              }),
          new LocalizedString(Arrays.asList("main-title"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Je suis Sylvain Janet");
                  put(TextLanguage.ENGLISH, "I am Sylvain Janet");
                }
              }),
          new LocalizedString(Arrays.asList("occupation-trainer"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Formateur");
                  put(TextLanguage.ENGLISH, "Trainer");
                }
              }),
          new LocalizedString(Arrays.asList("occupation-mathematician"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Mathématicien");
                  put(TextLanguage.ENGLISH, "Mathematician");
                }
              }),
          new LocalizedString(Arrays.asList("occupation-musician"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Musicien");
                  put(TextLanguage.ENGLISH, "Musician");
                }
              }),
          new LocalizedString(Arrays.asList("occupation-fullstack-dev"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "FullStack Developer");
                  put(TextLanguage.ENGLISH, "Développeur fullstack");
                }
              }),
          new LocalizedString(Arrays.asList("skills-title"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Compétences");
                  put(TextLanguage.ENGLISH, "Skills");
                }
              }),
          new LocalizedString(Arrays.asList("java-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Java");
                  put(TextLanguage.ENGLISH, "Java");
                }
              }),
          new LocalizedString(Arrays.asList("csharp-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "C#");
                  put(TextLanguage.ENGLISH, "C#");
                }
              }),
          new LocalizedString(Arrays.asList("python-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Python");
                  put(TextLanguage.ENGLISH, "Python");
                }
              }),
          new LocalizedString(Arrays.asList("js-ts-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Javascript / Typescript");
                  put(TextLanguage.ENGLISH, "Javascript / Typescript");
                }
              }),
          new LocalizedString(Arrays.asList("sql-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "SQL");
                  put(TextLanguage.ENGLISH, "SQL");
                }
              }),
          new LocalizedString(Arrays.asList("html-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "HTML");
                  put(TextLanguage.ENGLISH, "HTML");
                }
              }),
          new LocalizedString(Arrays.asList("latex-language"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "LATEX");
                  put(TextLanguage.ENGLISH, "LATEX");
                }
              }),
          new LocalizedString(Arrays.asList("about-me-title"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "A propos");
                  put(TextLanguage.ENGLISH, "About me");
                }
              }),
          new LocalizedString(Arrays.asList("about-me-content"),
              new HashMap<TextLanguage, String>() {
                /**
                 * Id for serialization.
                 */
                private static final long serialVersionUID =
                    -4282718139657747721L;

                {
                  put(TextLanguage.FRENCH, "Développeur FullStack et formateur."
                      + "[[1]]"
                      + "Mon parcours professionnel a commencé par des études "
                      + "en mathématiques : je suis normalien, agrégé de "
                      + "mathématiques, et j'ai un master en logique et en "
                      + "informatique théorique." + "[[2]]"
                      + "J'ai entamé ma carrière dans le développement "
                      + "informatique avec un titre professionnel Concepteur "
                      + "développeur d'applications Java." + "[[3]]"
                      + "J'ai participé au développement de plusieurs projets. "
                      + "J'ai des compétences dans des frameworks back-end"
                      + " comme Spring boot ou Entity Framework, et dans des "
                      + "frameworks front-end comme Angular ou Vue.js. J'ai "
                      + "également donné des formations en Python, Java, C#, "
                      + "Javascript, SQL ou encore en Algorithmique." + "[[4]]"
                      + "Enfin, j'ai plusieurs projets individuels, dont la "
                      + "portée est plus large et reflète mes intérêts "
                      + "personnels. De l'expression artistique avec la "
                      + "musique, ma curiosité pour les langues, ma passion "
                      + "pour les jeux." + "[[5]]"
                      + "Pour plus d'informations, voir " + "[[6,mon cv]]");
                  put(TextLanguage.ENGLISH,
                      "FullStack developer and trainer.[[1]]" + "[[1]]"
                          + "blablabla" + "[[2]]" + "blablablablabla" + "[[3]]"
                          + "blablablablablablablablabla" + "[[4]]"
                          + "blablablablablablablablablablablabla" + "[[5]]"
                          + "For more information, see " + "[[6,my cv]]");
                }
              })));

  private InitialData() {

  }
}
