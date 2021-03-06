/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2020 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.catroid.ui.dialogs.regexassistant;

import android.content.Context;
import android.content.DialogInterface;

import org.catrobat.catroid.R;
import org.catrobat.catroid.utils.HtmlRegexExtractor;

public class HtmlExtractorDialog extends RegularExpressionFeature {

	public HtmlExtractorDialog() {
		this.titleId = R.string.formula_editor_regex_html_extractor_dialog_title;
	}

	public void openDialog(Context context) {
		HtmlExtractorInputDialog.Builder builder = new HtmlExtractorInputDialog.Builder(context);
		builder.setKeywordHint(R.string.keyword_label);
		builder.setHtmlHint(R.string.html_label);
		builder.setPositiveButton(R.string.ok, new HtmlExtractorInputDialog.OnClickListener() {
			@Override
			public void onPositiveButtonClick(DialogInterface dialog, String keywordInput, String htmlInput) {
				HtmlRegexExtractor htmlRegexExt = new HtmlRegexExtractor(context);
				htmlRegexExt.searchKeyword(keywordInput, htmlInput);
			}
		});
		builder.setTitle(R.string.formula_editor_regex_html_extractor_dialog_title);
		builder.setNegativeButton(R.string.cancel, null);
		builder.show();
	}
}
